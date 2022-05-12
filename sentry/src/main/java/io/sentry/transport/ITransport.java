package io.sentry.transport;

import io.sentry.SentryEnvelope;
import io.sentry.hints.Hints;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/** A transport is in charge of sending the event to the Sentry server. */
public interface ITransport extends Closeable {
  void send(@NotNull SentryEnvelope envelope, @NotNull Hints hints) throws IOException;

  default void send(@NotNull SentryEnvelope envelope) throws IOException {
    send(envelope, new Hints());
  }

  /**
   * Flushes events queued up, but keeps the client enabled. Not implemented yet.
   *
   * @param timeoutMillis time in milliseconds
   */
  void flush(long timeoutMillis);
}
