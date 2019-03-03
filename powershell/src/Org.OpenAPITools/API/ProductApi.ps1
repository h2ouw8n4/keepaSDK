function Invoke-ProductApiProduct {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [String]
        ${key},
        [Parameter(Position = 1, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [Int32]
        ${domain},
        [Parameter(Position = 2, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${asin},
        [Parameter(Position = 3, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $false)]
        [String]
        ${code}
    )

    Process {
        'Calling method: ProductApi-Product' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:ProductApi.Product(
            ${key},
            ${domain},
            ${asin},
            ${code}
        )
    }
}

