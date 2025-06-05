/*
 * Copyright (c) 2022-2025, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.branding.preference.management.core.constant;

/**
 * Constants related to branding preference management.
 */
public class BrandingPreferenceMgtConstants {

    public static final String BRANDING_RESOURCE_TYPE = "BRANDING_PREFERENCES";
    public static final String APPLICATION_BRANDING_RESOURCE_TYPE = "APPLICATION_BRANDING_PREFERENCES";
    public static final String CUSTOM_TEXT_RESOURCE_TYPE = "CUSTOM_TEXT";
    public static final String ORGANIZATION_TYPE = "ORG";
    public static final String APPLICATION_TYPE = "APP";
    public static final String CUSTOM_TYPE = "CUSTOM";
    public static final String CUSTOM_CONTENT_TYPE = "custom";
    public static final String LAYOUT_KEY = "layout";
    public static final String ACTIVE_LAYOUT_KEY = "activeLayout";
    public static final String CUSTOM_LAYOUT = "custom";
    public static final String CUSTOM_CONTENT_KEY = "content";
    public static final String HTML_CONTENT_KEY = "html";
    public static final String CSS_CONTENT_KEY = "css";
    public static final String JS_CONTENT_KEY = "js";
    public static final String DEFAULT_LOCALE = "en-US";
    public static final String RESOURCE_NAME_SEPARATOR = "_";
    public static final String LOCAL_CODE_SEPARATOR = "-";
    public static final String PRE_ADD_BRANDING_PREFERENCE = "PRE_ADD_BRANDING_PREFERENCE";
    public static final String PRE_UPDATE_BRANDING_PREFERENCE = "PRE_UPDATE_BRANDING_PREFERENCE";
    public static final String BRANDING_PREFERENCE = "branding-preference";
    public static final String OLD_BRANDING_PREFERENCE = "old-branding-preference";
    public static final String NEW_BRANDING_PREFERENCE = "new-branding-preference";
    public static final String TENANT_DOMAIN = "tenant-domain";
    public static final String JAVASCRIPT = "javascript";
    public static final String BRANDING_URLS = "urls";
    public static final String CONFIGS = "configs";
    public static final String IS_BRANDING_ENABLED = "isBrandingEnabled";

    public static final String RESOURCE_NOT_EXISTS_ERROR_CODE = "CONFIGM_00017";
    public static final String RESOURCES_NOT_EXISTS_ERROR_CODE = "CONFIGM_00020";
    public static final String RESOURCE_ALREADY_EXISTS_ERROR_CODE = "CONFIGM_00013";

    /**
     * Enum for custom layout components.
     */
    public enum CustomLayoutComponents {

        MAIN_SECTION("MainSection");

        private final String componentName;

        CustomLayoutComponents(String componentName) {

            this.componentName = componentName;
        }

        public String getComponentName() {

            return componentName;
        }
    }

    /**
     * Enums for error messages.
     */
    public enum ErrorMessages {

        // Error messages related to branding preference configurations.
        ERROR_CODE_INVALID_BRANDING_PREFERENCE("BRANDINGM_00001",
                "Invalid Branding Preference configurations for tenant: %s."),
        @Deprecated
        ERROR_CODE_BRANDING_PREFERENCE_NOT_EXISTS("BRANDINGM_00002",
                "Branding preferences are not configured for tenant: %s."),
        ERROR_CODE_BRANDING_PREFERENCE_NOT_CONFIGURED("BRANDINGM_00002",
                "Branding preferences are not configured for type: %s, name: %s in tenant: %s."),
        ERROR_CODE_BRANDING_PREFERENCE_ALREADY_EXISTS("BRANDINGM_00003",
                "Branding preference already exists for tenant: %s."),
        ERROR_CODE_ERROR_GETTING_BRANDING_PREFERENCE("BRANDINGM_00004",
                "Error while getting branding preference configurations for tenant: %s."),
        ERROR_CODE_ERROR_ADDING_BRANDING_PREFERENCE("BRANDINGM_00005",
                "Unable to add branding preference configurations for tenant: %s."),
        ERROR_CODE_ERROR_DELETING_BRANDING_PREFERENCE("BRANDINGM_00006",
                "Unable to delete branding preference configurations for tenant: %s."),
        ERROR_CODE_ERROR_UPDATING_BRANDING_PREFERENCE("BRANDINGM_00007",
                "Unable to update branding preference configurations."),
        ERROR_CODE_ERROR_BUILDING_BRANDING_PREFERENCE("BRANDINGM_00008",
                "Unable to build branding preference from branding preference configurations for tenant: %s."),
        ERROR_CODE_ERROR_CHECKING_BRANDING_PREFERENCE_EXISTS("BRANDINGM_00009",
                "Error while checking branding preference configurations existence."),
        ERROR_CODE_UNSUPPORTED_ENCODING_EXCEPTION("BRANDINGM_00010",
                "Unsupported Encoding in the branding preference configurations of the tenant: %s."),
        ERROR_CODE_NOT_ALLOWED_BRANDING_PREFERENCE("BRANDINGM_00011",
                "Requested branding preference configuration: %s is not allowed for the organization."),
        ERROR_CODE_ERROR_CLEARING_BRANDING_PREFERENCE_RESOLVER_CACHE_HIERARCHY("BRANDINGM_00012",
                "Error while clearing branding preference resolver cache hierarchy for tenant: %s."),
        ERROR_CODE_APPLICATION_NOT_FOUND("BRANDINGM_00013",
                "There is no application with the name : %s , in the organization: %s."),
        ERROR_CODE_ERROR_VALIDATING_BRANDING_PREFERENCE("BRANDINGM_00021",
                "Error while validating branding preference configurations for the organization: %s."),
        // Error messages related to custom text configurations.
        ERROR_CODE_INVALID_CUSTOM_TEXT_PREFERENCE("BRANDINGM_00022",
                "Invalid custom text configurations for tenant: %s."),
        ERROR_CODE_CUSTOM_TEXT_PREFERENCE_NOT_EXISTS("BRANDINGM_00023",
                "Custom Text preferences are not configured for tenant: %s."),
        ERROR_CODE_CUSTOM_TEXT_ALREADY_EXISTS("BRANDINGM_00024",
                "Custom Text preference already exists for tenant: %s."),
        ERROR_CODE_ERROR_GETTING_CUSTOM_TEXT_PREFERENCE("BRANDINGM_00025",
                "Error while getting custom text preference configurations for tenant: %s."),
        ERROR_CODE_ERROR_ADDING_CUSTOM_TEXT_PREFERENCE("BRANDINGM_00026",
                "Unable to add custom text preference configurations for tenant: %s."),
        ERROR_CODE_ERROR_DELETING_CUSTOM_TEXT_PREFERENCE("BRANDINGM_00027",
                "Unable to delete custom text preference configurations for tenant: %s."),
        ERROR_CODE_ERROR_UPDATING_CUSTOM_TEXT_PREFERENCE("BRANDINGM_00028",
                "Unable to update custom text preference configurations."),
        ERROR_CODE_ERROR_BUILDING_CUSTOM_TEXT_PREFERENCE("BRANDINGM_00029",
                "Unable to build custom text preference from custom text configurations for tenant: %s."),
        ERROR_CODE_ERROR_BULK_DELETING_CUSTOM_TEXT_PREFERENCES("BRANDINGM_00030",
                "Unable to bulk delete custom text preferences for tenant: %s."),
        ERROR_CODE_ERROR_CLEARING_CUSTOM_TEXT_PREFERENCE_RESOLVER_CACHE_HIERARCHY("BRANDINGM_00031",
                "Error while clearing custom text preference resolver cache hierarchy for tenant: %s."),
        ERROR_CODE_INVALID_BRANDING_PREFERENCE_TYPE("BRANDINGM_00032",
                "Invalid branding preference type: %s for tenant: %s."),
        ERROR_CODE_ERROR_GETTING_APP_BRANDING_PREFERENCE("BRANDINGM_00033",
                "Error while getting app-level branding preference configurations for application id: %s " +
                        "in tenant: %s."),
        // Error messages related to custom layout content configurations.
        ERROR_CODE_INVALID_CUSTOM_LAYOUT_CONTENT("BRANDINGM_00034",
                "Invalid custom layout content."),
        ERROR_CODE_CUSTOM_LAYOUT_CONTENT_NOT_EXISTS("BRANDINGM_00035",
                "Custom layout content is not configured for : %s."),
        ERROR_CODE_CUSTOM_LAYOUT_CONTENT_NOT_CONFIGURED("BRANDINGM_00036",
                "Custom layout content is not configured for type: %s, name: %s in tenant: %s."),
        ERROR_CODE_CUSTOM_LAYOUT_CONTENT_ALREADY_EXISTS("BRANDINGM_00037",
                "Custom layout content already exists for : %s."),
        ERROR_CODE_ERROR_GETTING_CUSTOM_LAYOUT_CONTENT("BRANDINGM_00038",
                "Error while retrieving custom layout content configurations for : %s."),
        ERROR_CODE_ERROR_ADDING_CUSTOM_LAYOUT_CONTENT("BRANDINGM_00039",
                "Unable to add custom layout content configurations for : %s."),
        ERROR_CODE_ERROR_DELETING_CUSTOM_LAYOUT_CONTENT("BRANDINGM_00040",
                "Unable to delete custom layout content configurations for : %s."),
        ERROR_CODE_ERROR_UPDATING_CUSTOM_LAYOUT_CONTENT("BRANDINGM_00041",
                "Unable to update custom layout content configurations."),
        ERROR_CODE_ERROR_BUILDING_CUSTOM_LAYOUT_CONTENT("BRANDINGM_00042",
                "Unable to build custom layout content from configurations for : %s."),
        ERROR_CODE_ERROR_CHECKING_CUSTOM_LAYOUT_CONTENT_EXISTS("BRANDINGM_00043",
                "Error while checking existence of custom layout content configurations."),
        ERROR_CODE_ERROR_VALIDATING_CUSTOM_LAYOUT_CONTENT("BRANDINGM_00044",
                "Error while validating custom layout content configurations for : %s."),
        ERROR_CODE_ERROR_GETTING_APP_CUSTOM_LAYOUT_CONTENT("BRANDINGM_00045",
                "Error while getting app-level custom layout content for application id: %s."),
        ERROR_CODE_UNSUPPORTED_PREFERENCE_OBJECT_FORMAT("BRANDINGM_00046",
                "Error while reading the preference object. Unsupported format or invalid data found."),
        ERROR_CODE_MANDATORY_COMPONENT_NOT_FOUND("BRANDINGM_00047",
                "Mandatory component '%s' not found in the custom layout html content.");

        private final String code;
        private final String message;

        ErrorMessages(String code, String message) {

            this.code = code;
            this.message = message;
        }

        public String getCode() {

            return code;
        }

        public String getMessage() {

            return message;
        }

        @Override
        public String toString() {

            return code + ":" + message;
        }
    }
}
