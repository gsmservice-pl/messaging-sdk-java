/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package pl.gsmservice.gateway;

import pl.gsmservice.gateway.models.components.Security;

public interface SecuritySource {

    Security getSecurity();
    
    public static SecuritySource of(Security security) {
        return new DefaultSecuritySource(security);
    }

    public static class DefaultSecuritySource implements SecuritySource {
        private Security security;

        public DefaultSecuritySource(Security security) {
            this.security = security;
        }

        public Security getSecurity() {
            return security;
        }
    }
}
