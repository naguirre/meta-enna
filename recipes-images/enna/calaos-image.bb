DESCRIPTION = "Image with Calaos."

IMAGE_FEATURES += "splash package-management x11-base ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "connman"
IMAGE_INSTALL += "lighttpd lighttpd-module-fastcgi"
IMAGE_INSTALL += "php-cli php-fpm"
IMAGE_INSTALL += "calaos-server calaos-home calaos-web"
IMAGE_INSTALL += "tzdata tzdata-europe ntp"
IMAGE_INSTALL += "avahi-utils shairport"
#IMAGE_INSTALL += "squeezeplay-nogui"
IMAGE_INSTALL += "nano htop procps"

#IMAGE_INSTALL += "edje-utils elementary-tests"

