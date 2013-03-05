DESCRIPTION = "glib-networking contains the implementations of certain GLib networking features that cannot be implemented directly in GLib itself because of their dependencies."
HOMEPAGE = "http://git.gnome.org/browse/glib-networking/"
BUGTRACKER = "http://bugzilla.gnome.org"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=5f30f0716dfdd0d91eb439ebec522ec2"

SECTION = "libs"
DEPENDS = "glib-2.0 gnutls intltool-native"

PR = "r3"

SRC_URI = "${GNOME_MIRROR}/${BPN}/2.34/${BPN}-${PV}.tar.xz"

SRC_URI[md5sum] = "7c95f09884d563e27937ac6185b03a8d"
SRC_URI[sha256sum] = "00a92ec7b31f03a2fc1eeff568c0f1664e109b3add8c7042d2d420953f49dfde"

EXTRA_OECONF = "--without-ca-certificates"

inherit autotools pkgconfig

FILES_${PN} += "${libdir}/gio/modules/libgio*.so ${datadir}/dbus-1/services/"
FILES_${PN}-dbg += "${libdir}/gio/modules/.debug/"
FILES_${PN}-dev += "${libdir}/gio/modules/libgio*.la"
FILES_${PN}-staticdev += "${libdir}/gio/modules/libgio*.a"
