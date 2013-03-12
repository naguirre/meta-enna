DESCRIPTION = "JSON::XS - JSON serialising/deserialising, done correctly and fast"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r6"
LIC_FILES_CHKSUM = "files://COPYING;md5=043dba8b278e1db1b0ef93f30140b02b"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://backpan.perl.org/authors/id/M/ML/MLEHMANN/JSON-XS-${PV}.tar.gz"

SRC_URI[md5sum] = "4dc2a968e41f8cf330d46be12f221a12"
SRC_URI[sha256sum] = "f697d2372d362be72168ef855c62803f5a5ceb6e43a3132da7e9d9f50e10fd02"

S = "${WORKDIR}/JSON-XS-${PV}"

inherit cpan

FILES_${PN}-doc = "${PERLLIBDIRS}/*.pod"
FILES_${PN} = "${PERLLIBDIRS}"
FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/JSON/XS/.debug/"