DESCRIPTION = "Audio::Scan - Fast C scanning of audio file metadata"
SECTION = "libs"
LICENSE = "GPL"
SRCREV = "904"
PV = "svnr${SRCREV}"
PR = "r29"

LIC_FILES_CHKSUM="file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

ARM_INSTRUCTION_SET = "arm"

# This should match the version currently listed in SBS's modules.conf file
SRC_URI = "svn://svn.slimdevices.com/repos/opensource/tags/Audio-Scan;protocol=http;module=0.93"

S = "${WORKDIR}/0.93"

inherit cpan

export INCLUDE = "${STAGING_LIBDIR}/../include"

FILES_${PN}-dbg += "${libdir}/perl/vendor_perl/*/auto/Audio/Scan/.debug/"

FILES_${PN} = "${PERLLIBDIRS}"
