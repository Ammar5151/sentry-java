package io.sentry.spring;

import com.jakewharton.nopen.annotation.Open;
import io.sentry.EventProcessor;
import io.sentry.SentryEvent;
import io.sentry.hints.Hints;
import io.sentry.spring.tracing.TransactionNameProvider;
import io.sentry.util.Objects;
import javax.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;

/** Attaches transaction name from the HTTP request to {@link SentryEvent}. */
@Open
public class SentryRequestHttpServletRequestProcessor implements EventProcessor {
  private final @NotNull TransactionNameProvider transactionNameProvider;
  private final @NotNull HttpServletRequest request;

  public SentryRequestHttpServletRequestProcessor(
      final @NotNull TransactionNameProvider transactionNameProvider,
      final @NotNull HttpServletRequest request) {
    this.transactionNameProvider =
        Objects.requireNonNull(transactionNameProvider, "transactionNameProvider is required");
    this.request = Objects.requireNonNull(request, "request is required");
  }

  @Override
  public @NotNull SentryEvent process(
      final @NotNull SentryEvent event, final @NotNull Hints hints) {
    if (event.getTransaction() == null) {
      event.setTransaction(transactionNameProvider.provideTransactionName(request));
    }
    return event;
  }
}
