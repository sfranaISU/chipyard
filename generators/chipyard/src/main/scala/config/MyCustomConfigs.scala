package chipyard

import org.chipsalliance.cde.config.{Config}

// class LeanGemminiRocketConfig extends Config(
//   new gemmini.LeanGemminiConfig ++                                 // use Lean Gemmini systolic array GEMM accelerator
//   new freechips.rocketchip.rocket.WithNHugeCores(1) ++
//   new chipyard.config.WithSystemBusWidth(128) ++
//   new chipyard.config.AbstractConfig)

class DefaultRocketGemminiConfig extends Config(
  new gemmini.DefaultGemminiConfig ++                       // use Gemmini systolic array GEMM accelerator
  new freechips.rocketchip.rocket.WithNHugeCores(1) ++      // Huge rocket core (works but not what we want)
  new chipyard.config.WithSystemBusWidth(128) ++            // Add the bus?
  new chipyard.config.AbstractConfig)                       // I think all of them has this line at the end

class DefaultRocketGemminiAES256ECBConfig extends Config(
  new aes.WithAES256ECBAccel ++                                   // use Caliptra AES 256 ECB accelerator
  new gemmini.DefaultGemminiConfig ++      
  new freechips.rocketchip.rocket.WithNHugeCores(1) ++
  new chipyard.config.WithSystemBusWidth(256) ++
  new chipyard.config.AbstractConfig)