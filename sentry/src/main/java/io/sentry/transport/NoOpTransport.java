package io.sentry.transport;

import io.sentry.SentryEnvelope;
import io.sentry.hints.Hints;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Internal
public final class NoOpTransport implements ITransport {

  private static final NoOpTransport instance = new NoOpTransport();

  public static @NotNull NoOpTransport getInstance() {
    return instance;
  }

  private NoOpTransport() {}

  @Override
  public void send(final @NotNull SentryEnvelope envelope, final @NotNull Hints hints)
      throws IOException {}

  @Override
  public void flush(long timeoutMillis) {}

  @Override
  public void close() throws IOException {}
}
