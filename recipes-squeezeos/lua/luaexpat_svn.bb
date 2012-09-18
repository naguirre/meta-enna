DESCRIPTION = "LUA expat"
SECTION = "libs"
LICENSE = "Kepler"
SRCREV = "9704"
LIC_FILES_CHKSUM="file://README;md5=1b6320bc0884f5152ba7dcbfbb519abc"
BV = "1.0.2"

PV = "${BV}+svnr${SRCREV}"
#PR="r0"

DEPENDS = "lua expat"

SRC_URI="${SQUEEZEPLAY_SCM};module=luaexpat-${BV}"

INSANE_SKIP_${PN} = "dev-so"

S = "${WORKDIR}/luaexpat-${BV}"

EXTRA_OEMAKE = "PLATFORM=linux"

do_install() {
	oe_runmake install LUA_LIBDIR=${D}/${libdir}/lua/5.1 LUA_DIR=${D}/${datadir}/lua/5.1
}

PACKAGES = "liblua5.1-expat-dbg liblua5.1-expat"

FILES_liblua5.1-expat-dbg = "${libdir}/lua/5.1/.debug ${libdir}/lua/5.1/lxp.so"
FILES_liblua5.1-expat = "${libdir}/lua/5.1/lxp.so.* ${datadir}"
