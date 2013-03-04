DESCRIPTION = "Calaos Touch - image"

require ennaos-base-image.bb

IMAGE_INSTALL += " ${XSERVER} "
IMAGE_INSTALL += " ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-common "
IMAGE_INSTALL += " xserver-common xserver-nodm-init-systemd "
IMAGE_INSTALL += " e-wm-config-calaos e-wm-config-default e-wm-config-standard e-wm-config-mobile "
IMAGE_INSTALL += " watchdog "
IMAGE_INSTALL += " lighttpd lighttpd-module-fastcgi "
IMAGE_INSTALL += " avahi avahi-daemon avahi-systemd avahi-utils "
IMAGE_INSTALL += " php-cli "
IMAGE_INSTALL += " www-enna "
IMAGE_INSTALL += " alsa-utils-aplay alsa-utils-amixer "
IMAGE_INSTALL += " calaos-server calaos-home calaos-web"
IMAGE_INSTALL += " ajenti "

export IMAGE_BASENAME = "calaos-touch-image"
