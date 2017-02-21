# React Native example binding for gRPC

## More information

See [this blogpost](https://medium.com/@albert.brand/first-steps-in-grpc-bindings-for-react-native-32bb97115eed)

## Example prerequisites

Clone `grpc-java` and start the `hello-world-server` from the `grpc-java/examples` dir.
See [quickstart](http://www.grpc.io/docs/quickstart/java.html) for more info.
This server should start on localhost:50051.

Make sure to run `yarn` or `npm i` once from the project root.

## Run

Make sure an Android emulator runs or a device is connected. Then run:

```
adb reverse tcp:50051 tcp:50051
react-native run-android
```
