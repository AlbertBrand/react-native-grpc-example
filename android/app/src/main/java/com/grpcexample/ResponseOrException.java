package com.grpcexample;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

class ResponseOrException {
  private final ReadableMap response;
  private final Exception exception;

  ResponseOrException(WritableMap response) {
    this.response = response;
    this.exception = null;
  }

  ResponseOrException(Exception exception) {
    this.response = null;
    this.exception = exception;
  }

  ReadableMap getResponse() {
    return response;
  }

  Exception getException() {
    return exception;
  }

  boolean hasResponse() {
    return response != null;
  }
}
