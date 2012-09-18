DESCRIPTION = "LUA profiler"
SECTION = "libs"
LICENSE = "kelper"

SRCREV = "9704"

LIC_FILES_CHKSUM="file://config.linux;md5=fc3fcce55ab9dee74a97971be0079c5d"

BV = "2.0"

PV = "${BV}+svnr${SRCREV}"
#PR="r0"

DEPENDS = "lua"

SRC_URI="${SQUEEZEPLAY_SCM};module=luaprofiler-${BV}"

S = "${WORKDIR}/luaprofiler-${BV}"

CFLAGS += "-fPIC"

do_compile() {
	oe_runmake -f Makefile.linux
}

do_install() {
	mkdir -p ${D}/${libdir}/lua/5.1
	oe_runmake -f Makefile.linux install PREFIX=${D}/usr
}

PACKAGES = "liblua5.1-profiler-dbg liblua5.1-profiler"

FILES_liblua5.1-profiler-dbg = "/usr/src/debug  /usr/lib/lua/5.1/.debug"
FILES_liblua5.1-profiler = "${libdir}/lua/5.1/profiler.so ${bindir}"
