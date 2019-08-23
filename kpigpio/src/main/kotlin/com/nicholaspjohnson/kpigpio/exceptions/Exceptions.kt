package com.nicholaspjohnson.kpigpio.exceptions

private const val PI_INIT_FAILED = -1 // gpioInitialise failed
private const val PI_BAD_USER_GPIO = -2 // GPIO not 0-31
private const val PI_BAD_GPIO = -3 // GPIO not 0-53
private const val PI_BAD_MODE = -4 // mode not 0-7
private const val PI_BAD_LEVEL = -5 // level not 0-1
private const val PI_BAD_PUD = -6 // pud not 0-2
private const val PI_BAD_PULSEWIDTH = -7 // pulsewidth not 0 or 500-2500
private const val PI_BAD_DUTYCYCLE = -8 // dutycycle outside set range
private const val PI_BAD_TIMER = -9 // timer not 0-9
private const val PI_BAD_MS = -10 // ms not 10-60000
private const val PI_BAD_TIMETYPE = -11 // timetype not 0-1
private const val PI_BAD_SECONDS = -12 // seconds < 0
private const val PI_BAD_MICROS = -13 // micros not 0-999999
private const val PI_TIMER_FAILED = -14 // gpioSetTimerFunc failed
private const val PI_BAD_WDOG_TIMEOUT = -15 // timeout not 0-60000
private const val PI_NO_ALERT_FUNC = -16 // DEPRECATED
private const val PI_BAD_CLK_PERIPH = -17 // clock peripheral not 0-1
private const val PI_BAD_CLK_SOURCE = -18 // DEPRECATED
private const val PI_BAD_CLK_MICROS = -19 // clock micros not 1, 2, 4, 5, 8, or 10
private const val PI_BAD_BUF_MILLIS = -20 // buf millis not 100-10000
private const val PI_BAD_DUTYRANGE = -21 // dutycycle range not 25-40000
private const val PI_BAD_DUTY_RANGE = -21 // DEPRECATED (use PI_BAD_DUTYRANGE)
private const val PI_BAD_SIGNUM = -22 // signum not 0-63
private const val PI_BAD_PATHNAME = -23 // can't open pathname
private const val PI_NO_HANDLE = -24 // no handle available
private const val PI_BAD_HANDLE = -25 // unknown handle
private const val PI_BAD_IF_FLAGS = -26 // ifFlags > 4
private const val PI_BAD_CHANNEL = -27 // DMA channel not 0-15
private const val PI_BAD_PRIM_CHANNEL = -27 // DMA primary channel not 0-15
private const val PI_BAD_SOCKET_PORT = -28 // socket port not 1024-32000
private const val PI_BAD_FIFO_COMMAND = -29 // unrecognized fifo command
private const val PI_BAD_SECO_CHANNEL = -30 // DMA secondary channel not 0-15
private const val PI_NOT_INITIALISED = -31 // function called before gpioInitialise
private const val PI_INITIALISED = -32 // function called after gpioInitialise
private const val PI_BAD_WAVE_MODE = -33 // waveform mode not 0-3
private const val PI_BAD_CFG_INTERNAL = -34 // bad parameter in gpioCfgInternals call
private const val PI_BAD_WAVE_BAUD = -35 // baud rate not 50-250K(RX)/50-1M(TX)
private const val PI_TOO_MANY_PULSES = -36 // waveform has too many pulses
private const val PI_TOO_MANY_CHARS = -37 // waveform has too many chars
private const val PI_NOT_SERIAL_GPIO = -38 // no bit bang serial read on GPIO
private const val PI_BAD_SERIAL_STRUC = -39 // bad (null) serial structure parameter
private const val PI_BAD_SERIAL_BUF = -40 // bad (null) serial buf parameter
private const val PI_NOT_PERMITTED = -41 // GPIO operation not permitted
private const val PI_SOME_PERMITTED = -42 // one or more GPIO not permitted
private const val PI_BAD_WVSC_COMMND = -43 // bad WVSC subcommand
private const val PI_BAD_WVSM_COMMND = -44 // bad WVSM subcommand
private const val PI_BAD_WVSP_COMMND = -45 // bad WVSP subcommand
private const val PI_BAD_PULSELEN = -46 // trigger pulse length not 1-100
private const val PI_BAD_SCRIPT = -47 // invalid script
private const val PI_BAD_SCRIPT_ID = -48 // unknown script id
private const val PI_BAD_SER_OFFSET = -49 // add serial data offset > 30 minutes
private const val PI_GPIO_IN_USE = -50 // GPIO already in use
private const val PI_BAD_SERIAL_COUNT = -51 // must read at least a byte at a time
private const val PI_BAD_PARAM_NUM = -52 // script parameter id not 0-9
private const val PI_DUP_TAG = -53 // script has duplicate tag
private const val PI_TOO_MANY_TAGS = -54 // script has too many tags
private const val PI_BAD_SCRIPT_CMD = -55 // illegal script command
private const val PI_BAD_VAR_NUM = -56 // script variable id not 0-149
private const val PI_NO_SCRIPT_ROOM = -57 // no more room for scripts
private const val PI_NO_MEMORY = -58 // can't allocate temporary memory
private const val PI_SOCK_READ_FAILED = -59 // socket read failed
private const val PI_SOCK_WRIT_FAILED = -60 // socket write failed
private const val PI_TOO_MANY_PARAM = -61 // too many script parameters (> 10)
private const val PI_NOT_HALTED = -62 // DEPRECATED
private const val PI_SCRIPT_NOT_READY = -62 // script initialising
private const val PI_BAD_TAG = -63 // script has unresolved tag
private const val PI_BAD_MICS_DELAY = -64 // bad MICS delay (too large)
private const val PI_BAD_MILS_DELAY = -65 // bad MILS delay (too large)
private const val PI_BAD_WAVE_ID = -66 // non existent wave id
private const val PI_TOO_MANY_CBS = -67 // No more CBs for waveform
private const val PI_TOO_MANY_OOL = -68 // No more OOL for waveform
private const val PI_EMPTY_WAVEFORM = -69 // attempt to create an empty waveform
private const val PI_NO_WAVEFORM_ID = -70 // no more waveforms
private const val PI_I2C_OPEN_FAILED = -71 // can't open I2C device
private const val PI_SER_OPEN_FAILED = -72 // can't open serial device
private const val PI_SPI_OPEN_FAILED = -73 // can't open SPI device
private const val PI_BAD_I2C_BUS = -74 // bad I2C bus
private const val PI_BAD_I2C_ADDR = -75 // bad I2C address
private const val PI_BAD_SPI_CHANNEL = -76 // bad SPI channel
private const val PI_BAD_FLAGS = -77 // bad i2c/spi/ser open flags
private const val PI_BAD_SPI_SPEED = -78 // bad SPI speed
private const val PI_BAD_SER_DEVICE = -79 // bad serial device name
private const val PI_BAD_SER_SPEED = -80 // bad serial baud rate
private const val PI_BAD_PARAM = -81 // bad i2c/spi/ser parameter
private const val PI_I2C_WRITE_FAILED = -82 // i2c write failed
private const val PI_I2C_READ_FAILED = -83 // i2c read failed
private const val PI_BAD_SPI_COUNT = -84 // bad SPI count
private const val PI_SER_WRITE_FAILED = -85 // ser write failed
private const val PI_SER_READ_FAILED = -86 // ser read failed
private const val PI_SER_READ_NO_DATA = -87 // ser read no data available
private const val PI_UNKNOWN_COMMAND = -88 // unknown command
private const val PI_SPI_XFER_FAILED = -89 // spi xfer/read/write failed
private const val PI_BAD_POINTER = -90 // bad (NULL) pointer
private const val PI_NO_AUX_SPI = -91 // no auxiliary SPI on Pi A or B
private const val PI_NOT_PWM_GPIO = -92 // GPIO is not in use for PWM
private const val PI_NOT_SERVO_GPIO = -93 // GPIO is not in use for servo pulses
private const val PI_NOT_HCLK_GPIO = -94 // GPIO has no hardware clock
private const val PI_NOT_HPWM_GPIO = -95 // GPIO has no hardware PWM
private const val PI_BAD_HPWM_FREQ = -96 // invalid hardware PWM frequency
private const val PI_BAD_HPWM_DUTY = -97 // hardware PWM dutycycle not 0-1M
private const val PI_BAD_HCLK_FREQ = -98 // invalid hardware clock frequency
private const val PI_BAD_HCLK_PASS = -99 // need password to use hardware clock 1
private const val PI_HPWM_ILLEGAL = -100 // PWM in use for main clock
private const val PI_BAD_DATABITS = -101 // serial data bits not 1-32
private const val PI_BAD_STOPBITS = -102 // serial (half) stop bits not 2-8
private const val PI_MSG_TOOBIG = -103 // socket/pipe message too big
private const val PI_BAD_MALLOC_MODE = -104 // bad memory allocation mode
private const val PI_TOO_MANY_SEGS = -105 // too many I2C transaction segments
private const val PI_BAD_I2C_SEG = -106 // an I2C transaction segment failed
private const val PI_BAD_SMBUS_CMD = -107 // SMBus command not supported by driver
private const val PI_NOT_I2C_GPIO = -108 // no bit bang I2C in progress on GPIO
private const val PI_BAD_I2C_WLEN = -109 // bad I2C write length
private const val PI_BAD_I2C_RLEN = -110 // bad I2C read length
private const val PI_BAD_I2C_CMD = -111 // bad I2C command
private const val PI_BAD_I2C_BAUD = -112 // bad I2C baud not 50-500k
private const val PI_CHAIN_LOOP_CNT = -113 // bad chain loop count
private const val PI_BAD_CHAIN_LOOP = -114 // empty chain loop
private const val PI_CHAIN_COUNTER = -115 // too many chain counters
private const val PI_BAD_CHAIN_CMD = -116 // bad chain command
private const val PI_BAD_CHAIN_DELAY = -117 // bad chain delay micros
private const val PI_CHAIN_NESTING = -118 // chain counters nested too deeply
private const val PI_CHAIN_TOO_BIG = -119 // chain is too long
private const val PI_DEPRECATED = -120 // deprecated function removed
private const val PI_BAD_SER_INVERT = -121 // bit bang serial invert not 0 or 1
private const val PI_BAD_EDGE = -122 // bad ISR edge not 0-2
private const val PI_BAD_ISR_INIT = -123 // bad ISR initialisation
private const val PI_BAD_FOREVER = -124 // loop forever must be last command
private const val PI_BAD_FILTER = -125 // bad filter parameter
private const val PI_BAD_PAD = -126 // bad pad number
private const val PI_BAD_STRENGTH = -127 // bad pad drive strength
private const val PI_FIL_OPEN_FAILED = -128 // file open failed
private const val PI_BAD_FILE_MODE = -129 // bad file mode
private const val PI_BAD_FILE_FLAG = -130 // bad file flag
private const val PI_BAD_FILE_READ = -131 // bad file read
private const val PI_BAD_FILE_WRITE = -132 // bad file write
private const val PI_FILE_NOT_ROPEN = -133 // file not open for read
private const val PI_FILE_NOT_WOPEN = -134 // file not open for write
private const val PI_BAD_FILE_SEEK = -135 // bad file seek
private const val PI_NO_FILE_MATCH = -136 // no files match pattern
private const val PI_NO_FILE_ACCESS = -137 // no permission to access file
private const val PI_FILE_IS_A_DIR = -138 // file is a directory
private const val PI_BAD_SHELL_STATUS = -139 // bad shell return status
private const val PI_BAD_SCRIPT_NAME = -140 // bad script name
private const val PI_BAD_SPI_BAUD = -141 // bad SPI baud not 50-500k
private const val PI_NOT_SPI_GPIO = -142 // no bit bang SPI in progress on GPIO
private const val PI_BAD_EVENT_ID = -143 // bad event id
private const val PI_CMD_INTERRUPTED = -144 // Used by Python
private const val PI_NOT_ON_BCM2711 = -145 // not available on BCM2711
private const val PI_ONLY_ON_BCM2711 = -146 // only available on BCM2711

private const val PI_PIGIF_ERR_0 = -2000
private const val PI_PIGIF_ERR_99 = -2099

private const val PI_CUSTOM_ERR_0 = -3000
private const val PI_CUSTOM_ERR_999 = -3999

open class GPIOException(reason: String): RuntimeException(reason) {
    companion object {
        fun getProperThrowable(errCode: Int) : Class<out GPIOException> {
            println("getProperThrowable $errCode")
            return when(errCode) {
                PI_INIT_FAILED -> GPIOInitFailedException::class.java
                PI_BAD_USER_GPIO -> GPIOBadUserGPIOException::class.java
                PI_BAD_GPIO -> GPIOBadGPIOException::class.java
                PI_BAD_MODE -> GPIOBadModeException::class.java
                PI_BAD_LEVEL -> GPIOBadLevelException::class.java
                PI_BAD_PUD -> GPIOBadPUDException::class.java
                PI_BAD_PULSEWIDTH -> GPIOBadPulsewidthException::class.java
                PI_BAD_DUTYCYCLE -> GPIOBadDutycycleException::class.java
                PI_BAD_TIMER -> GPIOBadTimerException::class.java
                PI_BAD_MS -> GPIOBadMSException::class.java
                PI_BAD_TIMETYPE -> GPIOBadTimeTypeException::class.java
                PI_BAD_SECONDS -> GPIOBadSecondsException::class.java
                PI_BAD_MICROS -> GPIOBadMicrosException::class.java
                PI_TIMER_FAILED -> GPIOTimerFailedException::class.java
                PI_BAD_WDOG_TIMEOUT -> GPIOBadWatchdogTimeoutException::class.java
                PI_NO_ALERT_FUNC -> GPIONoAlertFunctionException::class.java

                PI_BAD_DUTYRANGE -> GPIOBadDutyrangeException::class.java

                PI_NOT_PWM_GPIO -> GPIONotPWMGPIOException::class.java

                else -> throw RuntimeException("Bad errCode $errCode")
            }
        }
    }
}

class GPIOInitFailedException: GPIOException("gpioInitialise failed")
class GPIOBadUserGPIOException: GPIOException("GPIO not 0-31")
class GPIOBadGPIOException: GPIOException("GPIO not 0-53")
class GPIOBadModeException: GPIOException("mode not 0-7")
class GPIOBadLevelException: GPIOException("level not 0-1")
class GPIOBadPUDException: GPIOException("pud not 0-2")
class GPIOBadPulsewidthException: GPIOException("pulsewidth not 0 or 500-2500")
class GPIOBadDutycycleException: GPIOException("dutycycle outside set range")
class GPIOBadTimerException: GPIOException("timer not 0-9")
class GPIOBadMSException: GPIOException("ms not 10-60000")
class GPIOBadTimeTypeException: GPIOException("timetype not 0-1")
class GPIOBadSecondsException: GPIOException("seconds < 0")
class GPIOBadMicrosException: GPIOException("micros not 0-999999")
class GPIOTimerFailedException: GPIOException("gpioSetTimerFunc failed")
class GPIOBadWatchdogTimeoutException: GPIOException("timeout not 0-60000")
class GPIONoAlertFunctionException: GPIOException("DEPRECATED")

class GPIOBadDutyrangeException: GPIOException("dutycycle range not 25-40000")

class GPIONotPWMGPIOException: GPIOException("GPIO is not in use for PWM")