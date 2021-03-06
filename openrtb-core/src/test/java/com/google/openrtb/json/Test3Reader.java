/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.openrtb.json;

import static com.google.openrtb.json.OpenRtbJsonUtils.getCurrentName;

import com.google.openrtb.OpenRtb.BidResponse;
import com.google.openrtb.TestExt;
import com.google.protobuf.Message;

import com.fasterxml.jackson.core.JsonParser;

import java.io.IOException;

/**
 * Sample JSON reader for a regular extension of scalar type.
 *
 * <p>This reader can only be used in a single message, in this case the {@code BidRequest}.
 * See {@link Test1Reader} how to keep the reader open to any message.
 */
public class Test3Reader extends OpenRtbJsonExtReader<BidResponse.Builder, Message.Builder> {

  @Override
  protected void read(BidResponse.Builder msg, JsonParser par) throws IOException {
    switch (getCurrentName(par)) {
      case "test3":
        msg.setExtension(TestExt.testResponse3, par.nextIntValue(0));
        break;
    }
  }
}
