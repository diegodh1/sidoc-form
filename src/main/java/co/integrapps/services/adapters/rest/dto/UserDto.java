package co.integrapps.services.adapters.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    @JsonProperty("AppUserID")
    private String userId;
    @JsonProperty("AppUserName")
    private String name;
    @JsonProperty("AppUserLastName")
    private String lastName;
    @JsonProperty("AppUserEmail")
    private String email;
    @JsonProperty("AppUserPassword")
    private String password;
    @JsonProperty("AppUserErpID")
    private Integer erpId;
    @JsonProperty("AppUserErpName")
    private String erpName;
    @JsonProperty("AppUserStatus")
    private Boolean isActive;
    @JsonProperty("F150Id")
    private String f150Id;
    @JsonProperty("AppUserErpAprueba")
    private Boolean isErpApprover;
}
