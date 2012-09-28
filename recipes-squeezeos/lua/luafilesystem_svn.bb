DESCRIPTION = "LUA filesystem"
SECTION = "libs"
LICENSE = "Kepler"

LIC_FILES_CHKSUM="file://config;md5=93977dc9195e1ed352ce646bf03fabba"

SRCREV = "9704"

BV = "1.2"

PV = "${BV}+svnr${SRCREV}"
#PR="r0"

DEPENDS = "lua"

SRC_URI="${SQUEEZEPLAY_SCM};module=luafilesystem-${BV}"

S = "${WORKDIR}/luafilesystem-${BV}"

EXTRA_OEMAKE = "PLATFORM=linux"

do_install() {
	oe_runmake install LUA_LIBDIR=${D}/${libdir}/lua/5.1
        rm -rf ${D}/${libdir}/lua/5.1/lfs.so
        ln -s lfs.so.1.2 ${D}/${libdir}/lua/5.1/lfs.so
}

PACKAGES = "liblua5.1-filesystem-dbg liblua5.1-filesystem"

INSANE_SKIP_liblua5.1-filesystem = "dev-so"

FILES_liblua5.1-filesystem-dbg += "${libdir}/lua/5.1/.debug/"
FILES_liblua5.1-filesystem += "${libdir}/lua/5.1/lfs.so ${libdir}/lua/5.1/lfs.so.*"
