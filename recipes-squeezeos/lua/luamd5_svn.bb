DESCRIPTION = "LUA md5/sha"
SECTION = "libs"
LICENSE = "Public domain"

SRCREV = "9704"

LIC_FILES_CHKSUM="file://README;md5=df30c0941d1f8eef9a5df9e482f0a3da"

PV = "0.1+svnr${SRCREV}"
#PR="r0"

DEPENDS = "lua"

SRC_URI="${SQUEEZEPLAY_SCM};module=luamd5"

S = "${WORKDIR}/luamd5"

do_compile() {
	${MAKE} CC="${CC}" LUA=${STAGING_DIR}/${HOST_SYS}/usr MYNAME=sha1
        ${MAKE} CC="${CC}" LUA=${STAGING_DIR}/${HOST_SYS}/usr MYNAME=md5
}

do_install() {
	mkdir -p ${D}${libdir}/lua/5.1
	install -m 0755 md5.so ${D}${libdir}/lua/5.1
	install -m 0755 sha1.so ${D}${libdir}/lua/5.1
}

PACKAGES = "liblua5.1-md5-dbg liblua5.1-md5"

FILES_liblua5.1-md5-dbg = "${libdir}/lua/5.1/.debug"
FILES_liblua5.1-md5 = "${libdir}"
