DESCRIPTION="A simple command to run on Unix systems that will check the time \
and optionally drift compared with a known, local and reliable NTP \
time server." 
LICENSE = "CLOSED"
PR = "r1"

SRC_URI = "http://downloads.slimdevices.com/poky-cache/msntp-${PV}.tar.gz"
SRC_URI[md5sum] = "3eefa15ace8567b46dfa67259407c333"
SRC_URI[sha256sum] = "30d170734d5ef8e7a5ba68ec2add4206a2133b43e3c7150100689304cf6528e5"

export LIBS = "-lm"

PACKAGES = "msntp"

FILES_msntp = "${sbindir}/msntp"

do_install () {
	# Install msntp
	install -m 0755 -d ${D}${sbindir}
	install -m 0755 ${S}/msntp ${D}${sbindir}/msntp
}