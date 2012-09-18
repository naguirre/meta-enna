DESCRIPTION = "axTLS SSL library"
SECTION = "libs"
PR = "r1"

LICENSE="closed"

SRC_URI = "http://downloads.sourceforge.net/axtls/axTLS-${PV}.tar.gz \
           file://axTLS.config \
	   "

S = "${WORKDIR}/axTLS"

do_configure() {
	cp ${WORKDIR}/axTLS.config ${S}/config/.config
	echo "PREFIX=\"${D}${prefix}\"" >> ${S}/config/.config
	oe_runmake oldconfig
}

do_install() {
	mkdir -p ${D}/usr/lib
	PREFIX=${D}/usr oe_runmake install

	# We _always_ want to staticaly link axtls, this seems to be
	# the easiest way to ensure that
	rm -f ${S}/_stage/libaxtls.so*
}

FILES_${PN} = "${libdir}/lib*${SOLIBS}"
FILES_${PN}-dev += "${bindir}"
