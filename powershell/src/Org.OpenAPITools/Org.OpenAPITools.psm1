#region Import functions

'API', 'Model', 'Private' | Get-ChildItem -Path {
    Join-Path $PSScriptRoot $_
} -Filter '*.ps1' | ForEach-Object {
    Write-Verbose "Importing file: $($_.BaseName)"
    try {
        . $_.FullName
    } catch {
        Write-Verbose "Can't import function!"
    }
}

#endregion


#region Initialize APIs

'Creating object: Org.OpenAPITools.Api.CategoryApi' | Write-Verbose
$Script:CategoryApi= New-Object -TypeName Org.OpenAPITools.Api.CategoryApi -ArgumentList @($null)

'Creating object: Org.OpenAPITools.Api.ProductApi' | Write-Verbose
$Script:ProductApi= New-Object -TypeName Org.OpenAPITools.Api.ProductApi -ArgumentList @($null)


#endregion
