# Small image that launches all home automation and Audio/Video services
require console-base-image.bb

DEPENDS += "task-base-extended"

IMAGE_INSTALL += " \
    task-base-extended \
"

export IMAGE_BASENAME = "enna-server-image"
