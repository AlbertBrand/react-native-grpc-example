package com.grpcexample;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;

import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;

public class GreeterModule extends ReactContextBaseJavaModule {
  public GreeterModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "Greeter";
  }

  @ReactMethod
  public void sayHello(final ReadableMap requestMap, final Promise responsePromise) {
    new ResponseTask(responsePromise) {
      @Override
      protected WritableMap getResponse() {
        HelloRequest request = HelloRequest.newBuilder()
            .setName(requestMap.getString("name"))
            .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(getChannel());
        HelloReply reply = stub.sayHello(request);

        WritableMap response = new WritableNativeMap();
        response.putString("message", reply.getMessage());
        return response;
      }
    }.execute();
  }
}
