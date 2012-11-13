DESCRIPTION = "Enna OS - image"

require ennaos-base-image.bb

IMAGE_INSTALL += " squeezeplay squeezeplay-desktop squeezeplay-systemd "
IMAGE_INSTALL += " watchdog "
IMAGE_INSTALL += " shairport "
IMAGE_INSTALL += " lighttpd lighttpd-module-fastcgi "
IMAGE_INSTALL += " avahi avahi-daemon avahi-systemd avahi-utils "
IMAGE_INSTALL += " php-cli php-cgi "
IMAGE_INSTALL += " www-enna "
IMAGE_INSTALL += " alsa-utils-aplay alsa-utils-amixer "

export IMAGE_BASENAME = "ennaos-image"
