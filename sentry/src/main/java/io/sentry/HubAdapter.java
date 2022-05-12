package io.sentry;

import io.sentry.hints.Hints;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class HubAdapter implements IHub {

  private static final HubAdapter INSTANCE = new HubAdapter();

  private HubAdapter() {}

  public static HubAdapter getInstance() {
    return INSTANCE;
  }

  @Override
  public boolean isEnabled() {
    return Sentry.isEnabled();
  }

  @Override
  public @NotNull SentryId captureEvent(@NotNull SentryEvent event, @Nullable Hints hints) {
    return Sentry.captureEvent(event, hints);
  }

  @Override
  public @NotNull SentryId captureMessage(@NotNull String message, @NotNull SentryLevel level) {
    return Sentry.captureMessage(message, level);
  }

  @ApiStatus.Internal
  @Override
  public @NotNull SentryId captureEnvelope(
      @NotNull SentryEnvelope envelope, @Nullable Hints hints) {
    return Sentry.getCurrentHub().captureEnvelope(envelope, hints);
  }

  @Override
  public @NotNull SentryId captureException(@NotNull Throwable throwable, @Nullable Hints hints) {
    return Sentry.captureException(throwable, hints);
  }

  @Override
  public void captureUserFeedback(@NotNull UserFeedback userFeedback) {
    Sentry.captureUserFeedback(userFeedback);
  }

  @Override
  public void startSession() {
    Sentry.startSession();
  }

  @Override
  public void endSession() {
    Sentry.endSession();
  }

  @Override
  public void close() {
    Sentry.close();
  }

  @Override
  public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable Hints hints) {
    Sentry.addBreadcrumb(breadcrumb, hints);
  }

  @Override
  public void setLevel(@Nullable SentryLevel level) {
    Sentry.setLevel(level);
  }

  @Override
  public void setTransaction(@Nullable String transaction) {
    Sentry.setTransaction(transaction);
  }

  @Override
  public void setUser(@Nullable User user) {
    Sentry.setUser(user);
  }

  @Override
  public void setFingerprint(@NotNull List<String> fingerprint) {
    Sentry.setFingerprint(fingerprint);
  }

  @Override
  public void clearBreadcrumbs() {
    Sentry.clearBreadcrumbs();
  }

  @Override
  public void setTag(@NotNull String key, @NotNull String value) {
    Sentry.setTag(key, value);
  }

  @Override
  public void removeTag(@NotNull String key) {
    Sentry.removeTag(key);
  }

  @Override
  public void setExtra(@NotNull String key, @NotNull String value) {
    Sentry.setExtra(key, value);
  }

  @Override
  public void removeExtra(@NotNull String key) {
    Sentry.removeExtra(key);
  }

  @Override
  public @NotNull SentryId getLastEventId() {
    return Sentry.getLastEventId();
  }

  @Override
  public void pushScope() {
    Sentry.pushScope();
  }

  @Override
  public void popScope() {
    Sentry.popScope();
  }

  @Override
  public void withScope(@NotNull ScopeCallback callback) {
    Sentry.withScope(callback);
  }

  @Override
  public void configureScope(@NotNull ScopeCallback callback) {
    Sentry.configureScope(callback);
  }

  @Override
  public void bindClient(@NotNull ISentryClient client) {
    Sentry.bindClient(client);
  }

  @Override
  public void flush(long timeoutMillis) {
    Sentry.flush(timeoutMillis);
  }

  @Override
  public @NotNull IHub clone() {
    return Sentry.getCurrentHub().clone();
  }

  @Override
  public @NotNull SentryId captureTransaction(
      @NotNull SentryTransaction transaction,
      @Nullable TraceState traceState,
      @Nullable Hints hints,
      @Nullable ProfilingTraceData profilingTraceData) {
    return Sentry.getCurrentHub()
        .captureTransaction(transaction, traceState, hints, profilingTraceData);
  }

  @Override
  public @NotNull ITransaction startTransaction(@NotNull TransactionContext transactionContexts) {
    return Sentry.startTransaction(transactionContexts);
  }

  @Override
  public @NotNull ITransaction startTransaction(
      @NotNull TransactionContext transactionContexts,
      @Nullable CustomSamplingContext customSamplingContext,
      boolean bindToScope) {
    return Sentry.startTransaction(transactionContexts, customSamplingContext, bindToScope);
  }

  @ApiStatus.Internal
  @Override
  public @NotNull ITransaction startTransaction(
      @NotNull TransactionContext transactionContexts,
      @Nullable CustomSamplingContext customSamplingContext,
      boolean bindToScope,
      @Nullable Date startTimestamp) {
    return Sentry.startTransaction(
        transactionContexts, customSamplingContext, bindToScope, startTimestamp);
  }

  @ApiStatus.Internal
  @Override
  public @NotNull ITransaction startTransaction(
      @NotNull TransactionContext transactionContexts,
      @Nullable CustomSamplingContext customSamplingContext,
      boolean bindToScope,
      @Nullable Date startTimestamp,
      boolean waitForChildren,
      @Nullable TransactionFinishedCallback transactionFinishedCallback) {
    return Sentry.startTransaction(
        transactionContexts,
        customSamplingContext,
        bindToScope,
        startTimestamp,
        waitForChildren,
        transactionFinishedCallback);
  }

  @Override
  public @Nullable SentryTraceHeader traceHeaders() {
    return Sentry.traceHeaders();
  }

  @Override
  public void setSpanContext(
      final @NotNull Throwable throwable,
      final @NotNull ISpan span,
      final @NotNull String transactionName) {
    Sentry.getCurrentHub().setSpanContext(throwable, span, transactionName);
  }

  @Override
  public @Nullable ISpan getSpan() {
    return Sentry.getCurrentHub().getSpan();
  }

  @Override
  public @NotNull SentryOptions getOptions() {
    return Sentry.getCurrentHub().getOptions();
  }

  @Override
  public @Nullable Boolean isCrashedLastRun() {
    return Sentry.isCrashedLastRun();
  }
}
