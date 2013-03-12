DESCRIPTION = "DBI - Database indpendent interface for Perl"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r9"
LIC_FILES_CHKSUM = "file://README;md5=7d84eff97c85807346532ad66a6bb3ec"
# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

ARM_INSTRUCTION_SET = "arm"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/T/TI/TIMB/DBI-${PV}.tar.gz"

SRC_URI[md5sum] = "799313e54a693beb635b47918458f7c4"
SRC_URI[sha256sum] = "60ce3986c46d12e0eae6def8b4804a90edd02c2cc6b0d2481854e6db8d99d054"

S = "${WORKDIR}/DBI-${PV}"

inherit cpan

FILES_${PN}-doc = "${PERLLIBDIRS}/*.pod"
FILES_${PN} = "${PERLLIBDIRS}"

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/DBI/.debug/"