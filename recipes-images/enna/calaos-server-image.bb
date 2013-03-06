DESCRIPTION = "Calaos server - image"

require ennaos-base-image.bb

# Music recipes 
IMAGE_INSTALL += " squeezeplay squeezeplay-desktop squeezeplay-systemd "
IMAGE_INSTALL += " shairport "

IMAGE_INSTALL += " watchdog "

# Web server
IMAGE_INSTALL += " lighttpd lighttpd-module-fastcgi "
IMAGE_INSTALL += " php-cli php-fpm"

# Services annoucement
IMAGE_INSTALL += " avahi avahi-daemon avahi-systemd avahi-utils "

# Sound utils
IMAGE_INSTALL += " alsa-utils-aplay alsa-utils-amixer "

# Home Automation
IMAGE_INSTALL += " calaos-server calaos-web"

# NAS
IMAGE_INSTALL += " ajenti "
IMAGE_INSTALL += " samba "

export IMAGE_BASENAME = "calaos-server-image"
