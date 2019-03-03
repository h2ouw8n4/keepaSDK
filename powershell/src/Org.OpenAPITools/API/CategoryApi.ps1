function Invoke-CategoryApiCategory {
    [CmdletBinding()]
    Param (
        [Parameter(Position = 0, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [String]
        ${key},
        [Parameter(Position = 1, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [Int32]
        ${domain},
        [Parameter(Position = 2, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [Int32]
        ${category},
        [Parameter(Position = 3, ValueFromPipeline = $true, ValueFromPipelineByPropertyName = $true, Mandatory = $true)]
        [Int32]
        ${parents}
    )

    Process {
        'Calling method: CategoryApi-Category' | Write-Verbose
        $PSBoundParameters | Out-DebugParameter | Write-Debug

        $Script:CategoryApi.Category(
            ${key},
            ${domain},
            ${category},
            ${parents}
        )
    }
}

