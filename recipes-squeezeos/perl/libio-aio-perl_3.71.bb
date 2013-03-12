DESCRIPTION = "IO::AIO - Asynchronous Input/Output"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r7"

LIC_FILES_CHKSUM = "file://README;md5=1a6f476828e318af8d57124b0af0eb2b"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://backpan.perl.org/authors/id/M/ML/MLEHMANN/IO-AIO-${PV}.tar.gz \
	file://libio-aio-perl-config.h \
	file://libio-aio-perl-Makefile.PL.patch;patch=1"

SRC_URI[md5sum] = "0b9a1c5054445a21e132e2fc8602f5d0"
SRC_URI[sha256sum] = "b294c083c7b874e6e38e15c3ca1328340f827b33d3a17c2047085ee69dcdf26a"

S = "${WORKDIR}/IO-AIO-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/IO/AIO/* \
               ${PERLLIBDIRS}"

cpan_do_configure_prepend () {
	cp ${WORKDIR}/libio-aio-perl-config.h ${S}/libeio/config.h	
}

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/IO/AIO/.debug/"