/**
 * Copyright © 2016-2021 The Thingsboard Authors
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
package org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class LwM2MServerSecurityConfig {

    @ApiModelProperty(position = 1, value = "Server short Id. Used as link to associate server Object Instance.\nThis identifier uniquely identifies each LwM2M Server configured for the LwM2M Client.\n" +
            "This Resource MUST be set when the Bootstrap-Server Resource has a value of 'false'. \n" +
            "The values ID:0 and ID:65535 values MUST NOT be used for identifying the LwM2M Server.", example = "123", readOnly = true)
    protected Integer shortServerId = 123;
    /** Security -> ObjectId = 0 'LWM2M Security' */
    @ApiModelProperty(position = 2, value = "Is Bootstrap Server or Lwm2m Server", example = "true or false", readOnly = true)
    protected boolean bootstrapServerIs = false;
    @ApiModelProperty(position = 3, value = "Host for 'No Security' mode", example = "0.0.0.0", readOnly = true)
    protected String host;
    @ApiModelProperty(position = 4, value = "Port for  Lwm2m Server: 'No Security' mode: Lwm2m Server or Bootstrap Server", example = "'5685' or '5687'", readOnly = true)
    protected Integer port;
    @ApiModelProperty(position = 7, value = "Client Hold Off Time. The number of seconds to wait before initiating a Client Initiated Bootstrap once the LwM2M Client has determined it should initiate this bootstrap mode. (This information is relevant for use with a Bootstrap-Server only.)", example = "1", readOnly = true)
    protected Integer clientHoldOffTime = 1;
    @ApiModelProperty(position = 8, value = "Server Public Key for 'Security' mode (DTLS): RPK or X509. Format: base64 encoded", example = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEAZ0pSaGKHk/GrDaUDnQZpeEdGwX7m3Ws+U/kiVat\n" +
            "+44sgk3c8g0LotfMpLlZJPhPwJ6ipXV+O1r7IZUjBs3LNA==", readOnly = true)
    protected String serverPublicKey;
    @ApiModelProperty(position = 9, value = "Bootstrap Server Account Timeout (If the value is set to 0, or if this resource is not instantiated, the Bootstrap-Server Account lifetime is infinite.)", example = "0", readOnly = true)
    Integer bootstrapServerAccountTimeout = 0;

    /** Config -> ObjectId = 1 'LwM2M Server' */
    @ApiModelProperty(position = 10, value = "Specify the lifetime of the registration in seconds.", example = "300", readOnly = true)
    private Integer lifetime = 300;
    @ApiModelProperty(position = 11, value = "The default value the LwM2M Client should use for the Minimum Period of an Observation in the absence of this parameter being included in an Observation.\n" +
            "If this Resource doesn’t exist, the default value is 0.", example = "1", readOnly = true)
    private Integer defaultMinPeriod = 1;
    /** ResourceID=6 'Notification Storing When Disabled or Offline' */
    @ApiModelProperty(position = 12, value = "If true, the LwM2M Client stores “Notify” operations to the LwM2M Server while the LwM2M Server account is disabled or the LwM2M Client is offline. After the LwM2M Server account is enabled or the LwM2M Client is online, the LwM2M Client reports the stored “Notify” operations to the Server.\n" +
            "If false, the LwM2M Client discards all the “Notify” operations or temporarily disables the Observe function while the LwM2M Server is disabled or the LwM2M Client is offline.\n" +
            "The default value is true.", example = "true", readOnly = true)
    private boolean notifIfDisabled = true;
    @ApiModelProperty(position = 14, value = "This Resource defines the transport binding configured for the LwM2M Client.\n" +
            "If the LwM2M Client supports the binding specified in this Resource, the LwM2M Client MUST use that transport for the Current Binding Mode.", example = "U", readOnly = true)
    private String binding = "U";
}
