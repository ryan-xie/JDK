/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package sun.jvm.hotspot.utilities.memo;

/** A memoized int. Override {@link #computeValue} in subclasses; call
    {@link #getValue} in using code. */

public abstract class MemoizedInt {
  private boolean computed;
  private int value;

  /** Should compute the value of this memoized object. This will only
      be called once, upon the first call to {@link #getValue}. */
  protected abstract int computeValue();

  /** Public accessor for the memoized value. */
  public int getValue() {
    if (!computed) {
      value = computeValue();
      computed = true;
    }
    return value;
  }
}
