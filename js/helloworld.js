// @flow
import { NativeModules } from "react-native";

export type HelloRequest = { name?: string };
export type HelloReply = { message?: string };

export const Greeter = {
  sayHello: (request: HelloRequest): Promise<HelloReply> => {
    return NativeModules.Greeter.sayHello(request);
  }
};
