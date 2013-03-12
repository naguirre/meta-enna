DESCRIPTION = "Class::XSAccessor - Generate fast XS accessors without runtime compilation"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r8"

LIC_FILES_CHKSUM = "file://README;md5=6be05bfcccdc84b24034347eb0df5d76"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SM/SMUELLER/Class-XSAccessor-${PV}.tar.gz"

SRC_URI[md5sum] = "990ec14dda99ff01a32f64708b1ce15f"
SRC_URI[sha256sum] = "e56da77445d1cf2f2f2112f5f34922027c6c658785cc0388289578ad67e257fa"

S = "${WORKDIR}/Class-XSAccessor-${PV}"

inherit cpan

FILES_${PN}-doc = "${PERLLIBDIRS}/*.pod"
FILES_${PN} = "${PERLLIBDIRS}"

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/Class/XSAccessor/.debug/"