DESCRIPTION = "Compress::Raw::Zlib - Low-Level Interface to zlib compression library"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS += "expat expat-native"
PR = "r1"
LIC_FILES_CHKSUM = "file://README;md5=c8767d7516229f07b26e42d1cf8b51f1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PM/PMQS/Compress-Raw-Zlib-${PV}.tar.gz"

S = "${WORKDIR}/Compress-Raw-Zlib-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

SRC_URI[md5sum] = "3e2ce271f1eada6d192f424a1168b24c"
SRC_URI[sha256sum] = "ec74b8d04e823ae40602b87c01c230a7c91979a06efcc2f672aceb7f2196128a"

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/Compress/Raw/Zlib/.debug/"