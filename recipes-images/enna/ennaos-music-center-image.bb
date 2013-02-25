DESCRIPTION = "Enna OS - music center image"

require ennaos-base-image.bb

IMAGE_INSTALL += " ${XSERVER} "
IMAGE_INSTALL += " squeezeplay-gui squeezeplay-desktop squeezeplay-systemd "
IMAGE_INSTALL += " ttf-dejavu-sans ttf-dejavu-sans-mono ttf-dejavu-common "
IMAGE_INSTALL += " xserver-common xserver-nodm-init-systemd "
IMAGE_INSTALL += " e-wm-config-angstrom e-wm-config-default e-wm-config-standard e-wm-config-mobile "
IMAGE_INSTALL += " watchdog "
IMAGE_INSTALL += " shairport "
IMAGE_INSTALL += " lighttpd lighttpd-module-fastcgi "
IMAGE_INSTALL += " avahi avahi-daemon avahi-systemd avahi-utils "
IMAGE_INSTALL += " php-cli "
IMAGE_INSTALL += " www-enna "
IMAGE_INSTALL += " alsa-utils-aplay alsa-utils-amixer "

export IMAGE_BASENAME = "ennaos-music-center-image"

