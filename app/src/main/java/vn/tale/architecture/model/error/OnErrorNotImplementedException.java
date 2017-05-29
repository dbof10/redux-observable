package vn.tale.architecture.model.error;

/**
 * Represents an exception used to re-throw {@link Subscriber#onError(Throwable)} when an implementation doesn't
 * exist.
 * <p>
 * Rx Design Guidelines 5.2:
 * <blockquote><p>
 * "when calling the Subscribe method that only has an onNext argument, the OnError behavior will be
 * to rethrow the exception on the thread that the message comes out from the observable sequence.
 * The OnCompleted behavior in this case is to do nothing."
 * </p></blockquote>
 *
 * @see <a href="https://github.com/ReactiveX/RxJava/issues/198">RxJava issue #198</a>
 */
public class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    /**
     * Customizes the {@code Throwable} with a custom message and wraps it before it is to be re-thrown as an
     * {@code OnErrorNotImplementedException}.
     *
     * @param message
     *          the message to assign to the {@code Throwable} to re-throw
     * @param e
     *          the {@code Throwable} to re-throw; if null, a NullPointerException is constructed
     */
    public OnErrorNotImplementedException(String message, Throwable e) {
        super(message, e != null ? e : new NullPointerException());
    }

    /**
     * Wraps the {@code Throwable} before it is to be re-thrown as an {@code OnErrorNotImplementedException}.
     *
     * @param e
     *          the {@code Throwable} to re-throw; if null, a NullPointerException is constructed
     */
    public OnErrorNotImplementedException(Throwable e) {
        super(e != null ? e.getMessage() : null, e != null ? e : new NullPointerException());
    }
}
