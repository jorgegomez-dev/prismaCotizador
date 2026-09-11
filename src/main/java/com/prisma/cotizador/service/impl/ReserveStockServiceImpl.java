package com.prisma.cotizador.service.impl;

import com.prisma.cotizador.service.ReserveStockService;

/** This class reserve stock in the database to avoid conflicts between
quotations stock and available stock for the job at the moment of confirmation
When the quotation is saved in the database, the stock of material is reserved
for this Job for a time-lapse determined for this service.
And when the Job is confirmed, the variable "isConfirmed" change to "true" and
the stock cant change. But if the job doesn't confirm for the client, the
time-lapse free the stock for another quotation.**/

public class ReserveStockServiceImpl implements ReserveStockService {
}
