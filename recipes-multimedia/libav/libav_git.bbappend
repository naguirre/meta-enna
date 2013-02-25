

PRINC := "${@int(PRINC) + 1}"

DEFAULT_PREFERENCE = "-1"

DEPENDS := "${@oe_filter_out('libvpx', '${DEPENDS}', d)}"

DEPENDS += "libpostproc"

EXTRA_OECONF := "${@oe_filter_out('--enable-postproc', '${EXTRA_OECONF}', d)}"
