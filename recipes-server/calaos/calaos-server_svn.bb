DESCRIPTION = "Calaos Server"
HOMEPAGE = "http://cairographics.org/pycairo"
BUGTRACKER = "http://bugs.freedesktop.org"
SECTION = "python-devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENCE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "ecore libsigc++-2.0 owfs log4cpp vmime jansson"
PR = "r2"

SRCREV="2192"
SRC_URI = "svn://dev.calaos.fr;module=calaos-svn;proto=http"

SRC_URI[md5sum] = "20337132c4ab06c1146ad384d55372c5"
SRC_URI[sha256sum] = "d30439f06c2ec1a39e27464c6c828b6eface3b22ee17b2de05dc409e429a7431"

S = "${WORKDIR}/calaos-svn/calaos_server"

inherit pkgconfig

do_configure() {
	BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} ./waf configure --prefix=${D}${prefix}
}

do_compile() {
	./waf build ${PARALLEL_MAKE}
}

do_install() {
	./waf install
}
