package org.wso2.carbon.identity.branding.preference.management.core.dao;

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.identity.branding.preference.management.core.exception.CustomContentServerException;
import org.wso2.carbon.identity.branding.preference.management.core.model.CustomContent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static org.wso2.carbon.identity.core.util.IdentityTenantUtil.getTenantId;

/**
 * CustomContentDAO is responsible for handling operations related to custom content persistence.
 * It provides implementation for adding, updating, checking existence, retrieving,
 * and deleting custom content specific to applications or organizations.
 * This class implements the CustomContentPersistentManager interface.
 */

public class CustomContentDAO implements CustomContentPersistentManager{

    private static final Log log = LogFactory.getLog(CustomContentDAO.class);

    private final OrgCustomContentDAO orgCustomContentDAO = new OrgCustomContentDAO();
    private final AppCustomContentDAO appCustomContentDAO = new AppCustomContentDAO();

    /**
     *
     * @param customContent         The Custom Content Object to be persisted
     * @param applicationUuid       Application UUID.
     * @param tenantDomain          Tenant domain.
     * @throws CustomContentServerException  If an error occurred while adding or updating the content.
     */

    @Override
    public void addOrUpdateCustomContent(CustomContent customContent, String applicationUuid, String tenantDomain) throws CustomContentServerException {
        int tenantId = getTenantId(tenantDomain);

        try{
            if (!isCustomContentExists(applicationUuid, tenantDomain)) {
                // DAO impl adds the content if not exists
                if (StringUtils.isBlank(applicationUuid)) {
                    // DAO impl adds the content to ORG table if applicationUuid is blank.
                    orgCustomContentDAO.addOrgCustomContent(customContent, tenantId);
                    if (log.isDebugEnabled()) {
                        log.debug(String.format(
                                "Custom content for tenant: %s successfully added.", tenantDomain));
                    }
                } else {
                    // DAO impl adds the content to APP table if applicationUuid is not blank.
                    appCustomContentDAO.addAppCustomContent(customContent, applicationUuid, tenantId);
                    if (log.isDebugEnabled()) {
                        log.debug(String.format(
                                "Custom content for application: %s for tenant: %s " +
                                        "successfully added.", applicationUuid, tenantDomain));
                    }
                }
            } else {
                // DAO impl updates the content if exists
                if (StringUtils.isBlank(applicationUuid)) {
                    orgCustomContentDAO.updateOrgCustomContent(customContent, tenantId);
                    if (log.isDebugEnabled()) {
                        log.debug(String.format(
                                "Custom content for tenant: %s successfully updated.",
                                tenantDomain));
                    }
                } else {
                    appCustomContentDAO.updateAppCustomContent(customContent, applicationUuid, tenantId);
                    if (log.isDebugEnabled()) {
                        log.debug(String.format(
                                "Custom content for application: %s for tenant: %s " +
                                        "successfully updated.",
                                applicationUuid, tenantDomain));
                    }
                }
            }
        }catch (CustomContentServerException e){
            throw new CustomContentServerException(e);
        }
    }

    /**
     *
     * @param applicationUuid       Application UUID.
     * @param tenantDomain          Tenant domain.
     * @return True if the custom content exists, false otherwise.
     * @throws CustomContentServerException If an error occurred while checking the existence.
     */

    @Override
    public boolean isCustomContentExists(String applicationUuid, String tenantDomain) throws CustomContentServerException {
        int tenantId = getTenantId(tenantDomain);

        if (StringUtils.isBlank(applicationUuid)) {
            if (log.isDebugEnabled()) {
                log.debug(String.format(
                        "Custom content existence for tenant: %s is successfully checked.", tenantDomain));
            }
            return orgCustomContentDAO.isOrgCustomContentAvailable(tenantId);
        } else {
            if (log.isDebugEnabled()) {
                log.debug(String.format(
                        "Custom content existence for application: %s for tenant: %s " +
                                "is successfully checked.", applicationUuid, tenantDomain));
            }
            return appCustomContentDAO.isAppCustomContentAvailable(applicationUuid, tenantId);
        }
    }

    /**
     *
     * @param applicationUuid       Application UUID.
     * @param tenantDomain          Tenant domain.
     * @return Custom Content for a particular APP or ORG
     * @throws CustomContentServerException If an error occurred while retrieving the content.
     */

    @Override
    public CustomContent getCustomContent(String applicationUuid, String tenantDomain) throws CustomContentServerException {
        int tenantId = getTenantId(tenantDomain);

        if (StringUtils.isBlank(applicationUuid)) {
            if (log.isDebugEnabled()) {
                log.debug(String.format(
                        "Custom content for tenant: %s successfully retrieved.", tenantDomain));
            }
            return orgCustomContentDAO.getOrgCustomContent(tenantId);
        } else {
            if (log.isDebugEnabled()) {
                log.debug(String.format(
                        "App %s template with locale: %s for type: %s for application: %s for tenant: %s " +
                                "successfully retrieved.", applicationUuid, tenantDomain));
            }
            return appCustomContentDAO.getAppCustomContent(applicationUuid, tenantId);
        }
    }

    /**
     *
     * @param applicationUuid       Application UUID.
     * @param tenantDomain          Tenant domain.
     * @throws CustomContentServerException If an error occurred while deleting the content.
     */

    @Override
    public void deleteCustomContent(String applicationUuid, String tenantDomain) throws CustomContentServerException {
        int tenantId = getTenantId(tenantDomain);

        if (StringUtils.isBlank(applicationUuid)) {
            orgCustomContentDAO.deleteOrgCustomContent(tenantId);
            if (log.isDebugEnabled()) {
                log.debug(String.format(
                        "Custom content for tenant: %s successfully deleted.", tenantDomain));
            }
        } else {
            appCustomContentDAO.deleteAppCustomContent(applicationUuid, tenantId);
            if (log.isDebugEnabled()) {
                log.debug(String.format(
                        "Custom content for application: %s for tenant: %s " +
                                "successfully deleted.", applicationUuid, tenantDomain));
            }
        }
    }
}
