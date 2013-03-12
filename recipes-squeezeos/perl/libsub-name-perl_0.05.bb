DESCRIPTION = "Sub::Name - (re)name a sub"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r6"
LIC_FILES_CHKSUM = "file://README;md5=484643c99a03f7f38bcccd23f0edd214"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/F/FL/FLORA/Sub-Name-${PV}.tar.gz"

SRC_URI[md5sum] = "26077202597620e4a6068c8087f3e09f"
SRC_URI[sha256sum] = "c9d1b805ea1f8e35fdde319468d6378dc1f1123cd8f2b22788238ba842713af1"

S = "${WORKDIR}/Sub-Name-${PV}"

inherit cpan

FILES_${PN}-doc = "${PERLLIBDIRS}/*.pod"
FILES_${PN} = "${PERLLIBDIRS}"

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/Sub/Name/.debug/"