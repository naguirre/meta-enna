PRINC := "${@int(PRINC) + 1}"

DEPENDS := "${@oe_filter_out('libvpx', '${DEPENDS}', d)}"
