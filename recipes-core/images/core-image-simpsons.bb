require ../../../meta-arcadia/recipes-core/images/core-image-arcadia.bb

SUMMARY = "Simpsosn image"
LICENSE = "MIT"

INHERIT:append = " buildhistory package package-index "

IMAGE_INSTALL:append:qemuall=" libgles1-mesa-dev libgles2-mesa-dev libgles3-mesa-dev "

COMPATIBLE_MACHINE = "odroid-xu4|qemuarm|qemux86-64|odroid-m1s"

