DESCRIPTION = "YAML::LibYAML"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

LIC_FILES_CHKSUM = "file://README;md5=b8de7f2e52518ce9a690c365e8f620e4"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/I/IN/INGY/YAML-LibYAML-${PV}.tar.gz"

SRC_URI[md5sum] = "9e047b14578aefd467d13aa612e6765b"
SRC_URI[sha256sum] = "3c54b124119cdf84655920594e7eb4d1f7c3a6067468fec3ff7376d4c46070d0"

S = "${WORKDIR}/YAML-LibYAML-${PV}"

inherit cpan

FILES_${PN}-doc = "${PERLLIBDIRS}/*.pod"
FILES_${PN} = "${PERLLIBDIRS}"

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/YAML/XS/LibYAML/.debug/"