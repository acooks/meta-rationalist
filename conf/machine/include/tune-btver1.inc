# Settings for the GCC(1) cpu-type "btver1":
#
#     AMD Bobcat CPU with 64-bit extensions, MMX, SSE, SSE2, SSE3, SSSE3,
#     SSE4A, CX16 and ABM instruction set support.
#
# This tune is recommended for AMD Bobcat CPUs.
#
DEFAULTTUNE ?= "btver1-64"

# Pull in the previous tune in to pull in PACKAGE_EXTRA_ARCHS
require conf/machine/include/tune-core2.inc

# Extra tune features
TUNEVALID[btver1] = "Enable AMD Bobcat specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains("TUNE_FEATURES", "btver1", " -march=btver1 -mtune=btver1 -mfpmath=sse -msse4a -msse -msse2", "", d)}"

# Extra tune selections
AVAILTUNES += "btver1-32"
TUNE_FEATURES_tune-btver1-32 = "${TUNE_FEATURES_tune-x86} btver1"
BASE_LIB_tune-btver1-32 = "lib"
TUNE_PKGARCH_tune-btver1-32 = "btver1-32"
PACKAGE_EXTRA_ARCHS_tune-btver1-32 = "${PACKAGE_EXTRA_ARCHS_tune-core2-32} btver1-32"

AVAILTUNES += "btver1-64"
TUNE_FEATURES_tune-btver1-64 = "${TUNE_FEATURES_tune-x86-64} btver1"
BASE_LIB_tune-btver1-64 = "lib64"
TUNE_PKGARCH_tune-btver1-64 = "btver1-64"
PACKAGE_EXTRA_ARCHS_tune-btver1-64 = "${PACKAGE_EXTRA_ARCHS_tune-core2-64} btver1-64"

AVAILTUNES += "btver1-64-x32"
TUNE_FEATURES_tune-btver1-64-x32 = "${TUNE_FEATURES_tune-x86-64-x32} btver1"
BASE_LIB_tune-btver1-64-x32 = "libx32"
TUNE_PKGARCH_tune-btver1-64-x32 = "btver1-64-x32"
PACKAGE_EXTRA_ARCHS_tune-btver1-64-x32 = "${PACKAGE_EXTRA_ARCHS_tune-core2-64-x32} btver1-64-x32"
