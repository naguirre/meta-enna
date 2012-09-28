LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit image

IMAGE_PREPROCESS_COMMAND = "rootfs_update_timestamp"

DISTRO_UPDATE_ALTERNATIVES ??= ""
ROOTFS_PKGMANAGE_PKGS ?= '${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${ROOTFS_PKGMANAGE} ${DISTRO_UPDATE_ALTERNATIVES}", d)}'

CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-tests connman-tools"

IMAGE_DEV_MANAGER ?= " udev "
IMAGE_INIT_MANAGER ?= " systemd "
IMAGE_INITSCRIPTS ?= " "
IMAGE_LOGIN_MANAGER ?= " tinylogin "

IMAGE_INSTALL += " \
    base-files \
    busybox \
    dbus-systemd \
    ${IMAGE_INITSCRIPTS} \
    ${IMAGE_DEV_MANAGER} \
    ${IMAGE_INIT_MANAGER} \
    ${IMAGE_LOGIN_MANAGER} \
    ${CONMANPKGS} \
    ${ROOTFS_PKGMANAGE_PKGS} \
"



