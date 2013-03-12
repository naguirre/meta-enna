DESCRIPTION = "EV - perl interface to libev, a high performance full-featured event loop"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r4"

LIC_FILES_CHKSUM = "files://COPYING;md5=2e872f42bf5f377e6acaea460bfcc371"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://backpan.perl.org/authors/id/M/ML/MLEHMANN/EV-${PV}.tar.gz"

SRC_URI[md5sum] = "33088705bc34bf66bccde50205c15e9f"
SRC_URI[sha256sum] = "d82190cf122fd5fa3bdb4d6f83d3221d0eb8024961e3db0a55fd867b63ccf594"

S = "${WORKDIR}/EV-${PV}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

FILES_${PN} = "${PERLLIBDIRS}/auto/EV/* \
               ${PERLLIBDIRS}"

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/EV/.debug/"
