DESCRIPTION = "Calaos Touch - image"

require ennaos-base-image.bb

IMAGE_FEATURES += "splash"

IMAGE_INSTALL += " ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-common "
IMAGE_INSTALL += " xserver-common xserver-nodm-init-systemd "
IMAGE_INSTALL += " watchdog "
IMAGE_INSTALL += " lighttpd lighttpd-module-fastcgi "
IMAGE_INSTALL += " avahi avahi-daemon avahi-systemd avahi-utils "
IMAGE_INSTALL += " php-cli php-fpm"
IMAGE_INSTALL += " alsa-utils-aplay alsa-utils-amixer "
IMAGE_INSTALL += " calaos-server calaos-home calaos-web"
IMAGE_INSTALL += " ntp "
IMAGE_INSTALL += " shairport squeezeplay squeezeplay-desktop squeezeplay-systemd "
IMAGE_INSTALL += " nfs-utils samba " 

export IMAGE_BASENAME = "calaos-touch-image"
