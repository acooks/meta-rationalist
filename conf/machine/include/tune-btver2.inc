# Settings for the GCC(1) cpu-type "btver2":
#
#     AMD Jaguar CPU with 64-bit extensions, MMX, SSE, SSE2, SSE3, SSSE3,
#     SSE4A, SSE4, SSE4.1, SSE4.2, AES, AVX, BMI1, F16C, CX16 and ABM
#     instruction set support.
#
# This tune is recommended for AMD Jaguar CPUs.
#
DEFAULTTUNE ?= "btver2-64"

# Pull in the previous tune in to pull in PACKAGE_EXTRA_ARCHS
require conf/machine/include/tune-core2.inc

# Extra tune features
TUNEVALID[btver2] = "Enable AMD Bobcat specific processor optimizations"
TUNE_CCARGS .= "${@bb.utils.contains("TUNE_FEATURES", "btver2", " -march=btver2 -mtune=btver2 -mfpmath=sse -msse4a -msse4 -msse4.1 -msse4.2 -msse -msse2", "", d)}"

# Extra tune selections
AVAILTUNES += "btver2-32"
TUNE_FEATURES_tune-btver2-32 = "${TUNE_FEATURES_tune-x86} btver2"
BASE_LIB_tune-btver2-32 = "lib"
TUNE_PKGARCH_tune-btver2-32 = "btver2-32"
PACKAGE_EXTRA_ARCHS_tune-btver2-32 = "${PACKAGE_EXTRA_ARCHS_tune-core2-32} btver2-32"

AVAILTUNES += "btver2-64"
TUNE_FEATURES_tune-btver2-64 = "${TUNE_FEATURES_tune-x86-64} btver2"
BASE_LIB_tune-btver2-64 = "lib64"
TUNE_PKGARCH_tune-btver2-64 = "btver2-64"
PACKAGE_EXTRA_ARCHS_tune-btver2-64 = "${PACKAGE_EXTRA_ARCHS_tune-core2-64} btver2-64"

AVAILTUNES += "btver2-64-x32"
TUNE_FEATURES_tune-btver2-64-x32 = "${TUNE_FEATURES_tune-x86-64-x32} btver2"
BASE_LIB_tune-btver2-64-x32 = "libx32"
TUNE_PKGARCH_tune-btver2-64-x32 = "btver2-64-x32"
PACKAGE_EXTRA_ARCHS_tune-btver2-64-x32 = "${PACKAGE_EXTRA_ARCHS_tune-core2-64-x32} btver2-64-x32"
