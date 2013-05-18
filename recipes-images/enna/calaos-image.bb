DESCRIPTION = "Image with Calaos."

IMAGE_FEATURES += "splash package-management x11-base ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "connman"
IMAGE_INSTALL += "ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-common"
IMAGE_INSTALL += "lighttpd lighttpd-module-fastcgi"
IMAGE_INSTALL += "php-cli php-fpm"
IMAGE_INSTALL += "calaos-server calaos-home calaos-web"
IMAGE_INSTALL += "ntp"
IMAGE_INSTALL += "shairport squeezeplay squeezeplay-desktop"
IMAGE_INSTALL += "nfs-utils samba" 


