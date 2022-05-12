package io.sentry;

import io.sentry.hints.Hints;
import io.sentry.protocol.SentryRuntime;
import io.sentry.protocol.SentryTransaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** Attaches Java vendor and version to events and transactions. */
final class SentryRuntimeEventProcessor implements EventProcessor {
  private final @Nullable String javaVersion;
  private final @Nullable String javaVendor;

  public SentryRuntimeEventProcessor(
      final @Nullable String javaVersion, final @Nullable String javaVendor) {
    this.javaVersion = javaVersion;
    this.javaVendor = javaVendor;
  }

  public SentryRuntimeEventProcessor() {
    this(System.getProperty("java.version"), System.getProperty("java.vendor"));
  }

  @Override
  public @NotNull SentryEvent process(
      final @NotNull SentryEvent event, final @Nullable Hints hints) {
    return process(event);
  }

  @Override
  public @NotNull SentryTransaction process(
      final @NotNull SentryTransaction transaction, final @Nullable Hints hints) {
    return process(transaction);
  }

  private <T extends SentryBaseEvent> @NotNull T process(final @NotNull T event) {
    if (event.getContexts().getRuntime() == null) {
      event.getContexts().setRuntime(new SentryRuntime());
    }
    final SentryRuntime runtime = event.getContexts().getRuntime();
    if (runtime != null && runtime.getName() == null && runtime.getVersion() == null) {
      runtime.setName(javaVendor);
      runtime.setVersion(javaVersion);
    }
    return event;
  }
}
